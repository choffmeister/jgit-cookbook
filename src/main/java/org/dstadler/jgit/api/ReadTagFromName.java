package org.dstadler.jgit.api;

import java.io.IOException;

import org.dstadler.jgit.helper.CookbookHelper;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;

/**
 * Simple snippet which shows how to use RevWalk to read tags
 */
public class ReadTagFromName {

    public static void main(String[] args) throws IOException, GitAPIException {
        Repository repository = CookbookHelper.openJGitCookbookRepository();

        // a RevWalk allows to retrieve information from the repository
        RevWalk walk = new RevWalk(repository);

        // a simple tag that is not annotated
        Ref simpleTag = repository.getRef("initialtag");
        RevObject any = walk.parseAny(simpleTag.getObjectId());
        System.out.println("Commit: " + any);

        // an annotated tag
        Ref annotatedTag = repository.getRef("secondtag");
        any = walk.parseAny(annotatedTag.getObjectId());
        System.out.println("Tag: " + any);

        // finally try to print out the tag-content
        System.out.println("\nTag-Content: \n");
        ObjectLoader loader = repository.open(annotatedTag.getObjectId());
        loader.copyTo(System.out);

        repository.close();
    }
}
