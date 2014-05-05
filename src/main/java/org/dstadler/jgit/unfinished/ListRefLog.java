package org.dstadler.jgit.unfinished;

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

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.dstadler.jgit.helper.CookbookHelper;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;



/**
 * Simple snippet which shows how to list all Tags
 * 
 * @author dominik.stadler at gmx.at
 */
public class ListRefLog {

    public static void main(String[] args) throws IOException, GitAPIException {
        Repository repository = CookbookHelper.openJGitCookbookRepository();

        List<Ref> refs = new Git(repository).branchList().call();
        for (Ref ref : refs) {
            System.out.println("Branch: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());

            listReflog(repository, ref);
        }

        List<Ref> call = new Git(repository).tagList().call();
        for (Ref ref : call) {
            System.out.println("Tag: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());

            listReflog(repository, ref);
        }

        repository.close();
    }

    private static void listReflog(Repository repository, Ref ref) throws GitAPIException, InvalidRefNameException, IOException {
        /*
         * Ref head = repository.getRef(ref.getName());
         * RevWalk walk = new RevWalk(repository);
         * RevCommit commit = walk.parseCommit(head.getObjectId());
         */

        Collection<ReflogEntry> call = new Git(repository).reflog().setRef(ref.getName()).call();
        Iterator<ReflogEntry> it = call.iterator();
        while (it.hasNext()) {
            ReflogEntry reflog = it.next();
            System.out.println("Reflog: " + reflog);
        }
    }
}
