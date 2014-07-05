package org.dstadler.jgit.porcelain;

/*
 * Copyright 2013, 2014 Dominik Stadler
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.dstadler.jgit.helper.CookbookHelper;
import org.eclipse.jgit.api.ArchiveCommand;
import org.eclipse.jgit.api.ArchiveCommand.Format;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Repository;



/**
 * Simple snippet which shows how to package the contents of a branch into an archive file.
 * 
 * @author dominik.stadler at gmx.at
 */
public class CreateArchive {

    /**
     * A custom format for Zip-files, unfortunately JGit does not come with any pre-defined ones
     */
    private static final class ZipArchiveFormat implements Format<ZipOutputStream> {

        public ZipOutputStream createArchiveOutputStream(OutputStream s) throws IOException {
            return new ZipOutputStream(s);
        }

        public void putEntry(ZipOutputStream out, String path, FileMode mode, ObjectLoader loader) throws IOException {
            // loader is null for directories...
            if (loader != null) {
                ZipEntry entry = new ZipEntry(path);
                out.putNextEntry(entry);
                out.write(loader.getBytes());
                out.closeEntry();
            }
        }

        public Iterable<String> suffixes() {
            return Collections.singleton(".zip");
        }
    }

    public static void main(String[] args) throws IOException, GitAPIException {
        Repository repository = CookbookHelper.openJGitCookbookRepository();


        File file = File.createTempFile("test", ".zip");
        // make the archive format known
        ArchiveCommand.registerFormat("zip", new ZipArchiveFormat());
        try {
            // this is the file that we write the archive to
            OutputStream out = new FileOutputStream(file);
            try {
                // finally call the ArchiveCommand to write out using the given format
                new Git(repository).archive()
                        .setTree(repository.resolve("master"))
                        .setFormat("zip")
                        .setOutputStream(out)
                        .call();
            } finally {
                out.close();
            }
        } finally {
            ArchiveCommand.unregisterFormat("zip");
        }

        System.out.println("Wrote " + file.length() + " bytes to " + file);

        repository.close();
    }
}
