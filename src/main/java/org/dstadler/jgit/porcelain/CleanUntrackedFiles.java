package org.dstadler.jgit.porcelain;

/*
   Copyright 2013, 2014 Dominik Stadler

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.dstadler.jgit.helper.CookbookHelper;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;



/**
 * Simple snippet which shows how to list all Tags
 *
 * @author dominik.stadler at gmx.at
 */
public class CleanUntrackedFiles {

    public static void main(String[] args) throws IOException, GitAPIException {
        Repository repository = CookbookHelper.createNewRepository();

        System.out.println("Repository at " + repository.getWorkTree());

        File untrackedFile = File.createTempFile("untracked", ".txt", repository.getWorkTree());
        File untrackedDir = File.createTempFile("untrackedDir", "", repository.getWorkTree());
        untrackedDir.delete();
        untrackedDir.mkdirs();

        System.out.println("Untracked exists: " + untrackedFile.exists() + " Dir: " + untrackedDir.exists() + "/" + untrackedDir.isDirectory());

        Set<String> removed = new Git(repository).clean().setCleanDirectories(true).call();
        for(String item : removed) {
        	System.out.println("Removed: " + item);
        }
        System.out.println("Removed " + removed.size() + " items");

        System.out.println("Untracked after: " + untrackedFile.exists() + " Dir: " + untrackedDir.exists() + "/" + untrackedDir.isDirectory());

        repository.close();
    }
}
