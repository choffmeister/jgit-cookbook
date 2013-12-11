package org.dstadler.jgit.porcelain;

import java.io.File;
import java.io.IOException;

import org.dstadler.jgit.helper.CookbookHelper;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;



/**
 * Simple snippet which shows how to commit a file
 * 
 * @author dominik.stadler@gmx.at
 */
public class CommitFile {

    public static void main(String[] args) throws IOException, GitAPIException {
        // prepare a new test-repository
        Repository repository = CookbookHelper.createNewRepository();
        Git git = new Git(repository);

        // create the file
        File myfile = new File(repository.getDirectory().getParent(), "testfile");
        myfile.createNewFile();

        // run the add
        git.add()
                .addFilepattern("testfile")
                .call();

        // and then commit the changes
        git.commit()
                .setMessage("Added testfile")
                .call();

        System.out.println("Committed file " + myfile + " to repository at " + repository.getDirectory());

        repository.close();
    }
}
