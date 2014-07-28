jgit-cookbook
=============
[![Build Status](https://buildhive.cloudbees.com/job/centic9/job/jgit-cookbook/badge/icon)](https://buildhive.cloudbees.com/job/centic9/job/jgit-cookbook/)

Provides examples and code snippets for the [JGit](http://wiki.eclipse.org/JGit/) Java Git implementation. 

The JGit framework is rich and diverse, it has two layers, a low-level _api_ and a higher-level set of _porcelain_ commands. 

This project tries to provide a collection of ready-to-run snippets which try to augment the existing [JavaDoc](http://download.eclipse.org/jgit/docs/latest/apidocs/) and the [User Guide](http://wiki.eclipse.org/JGit/User_Guide)

#### Getting started

##### Grab it

    git clone git://github.com/centic9/jgit-cookbook

##### Build it and create Eclipse project files

	mvn dependency:sources eclipse:eclipse package

#### Run it

    Import the project into an Eclipse workspace and execute the snippets there.

#### Currently the following snippets are available

##### General Repository handling

* [Open an existing repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/OpenRepository.java)
* [Create a new repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/CreateNewRepository.java)

##### Porcelain commands

* [Initialize a new repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/InitRepository.java)
* [Add a new file to the index](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/AddFile.java)
* [Commit a file to an existing repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CommitFile.java)
* [List commits (i.e. Log)](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ShowLog.java)
* [List all tags in a repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ListTags.java)
* [List all branches in a repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ListBranches.java)
* [List all commits in a repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/WalkAllCommits.java)
* [Create and delete branches](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CreateAndDeleteBranch.java)
* [Create and delete tags](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CreateAndDeleteTag.java)
* [Return diff between two branches](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ShowBranchDiff.java)
* [Show diff of changes to a file between two revs](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ShowFileDiff.java)
* [Show Status](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ShowStatus.java)
* [Store contents of branch into a compressed file](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CreateArchive.java)
* [Write contents of branch into a compressed file using a custom archive format](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CreateCustomFormatArchive.java)
* [Blame, i.e. find out which commit changed specific lines in a file](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ShowBlame.java)
* [Add and list Notes attached to commits](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/AddAndListNoteOfCommit.java)
* [List available Notes](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ListNotes.java)
* [Clean all untracked files](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CleanUntrackedFiles.java)
* [Create, list, apply and drop stashes](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CreateListApplyAndDropStash.java)
* [Run garbage collection](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CollectGarbage.java)

##### Commands working with remote repositories

* [Clone a remote reppository into a new local directory](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/CloneRemoteRepository.java)
* [Iterate remote references in a repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ListRemotes.java)
* [List remote heads/tags without a local clone](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/ListRemoteRepository.java)
* [Fetch from remote repositories](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/porcelain/FetchRemoteCommits.java)

##### Low-level API

* [Get the SHA-1 ref from a name, e.g. refs/heads/master](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/GetRefFromName.java)
* [Get the commit-object from a name or a SHA-1](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/GetRevCommitFromObjectId.java)
* [Get the commit-message](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/GetCommitMessage.java)
* [Get the tree-object from a commit-object, name or SHA-1](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/GetRevTreeFromObjectId.java)
* [Read the contents of a file/blob](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/ReadBlobContents.java)
* [Get the tag-object from a name or a SHA-1](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/ReadTagFromName.java)
* [Resolve complex references, e.g. HEAD^^ to a SHA-1](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/ResolveRef.java)
* [Iterate over the commits on a branch](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/WalkRev.java)
* [Read contents of a specific file from a specific commit](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/ReadFileFromCommit.java)
* [List remotes configured for the current repository](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/PrintRemotes.java)
* [Print out user information from Git](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/ReadUserConfig.java)
* [Read file attributes, e.g. executeable state, file or directory, size, ...](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/GetFileAttributes.java)
* [Use class BranchTrackingStatus to retrieve number of commits ahead/behind compared to remote branches](https://github.com/centic9/jgit-cookbook/blob/master/src/main/java/org/dstadler/jgit/api/ShowBranchTrackingStatus.java)

#### Missing snippets

* Iterate all commits of a repository - https://gerrit.googlesource.com/plugins/branch-network/+log/refs/heads/master/src/main/java/com/googlesource/gerrit/plugins/branchnetwork/data/JGitFacade.java
* Take some of the unit tests as example: https://github.com/eclipse/jgit/tree/master/org.eclipse.jgit.test/tst/org/eclipse/jgit/api
* Add/Remove/Read Notes
* SubModules: http://stackoverflow.com/questions/13426798/jgit-read-gitmodules
* Diffing: http://stackoverflow.com/questions/12987364/how-to-diff-with-two-files-by-jgit-without-creating-repo
* Ammend a previous commit: http://stackoverflow.com/questions/4772142/jgit-unstaging-files-removing-files-from-the-index-and-ammending-a-commit
* Remove a file from the index: http://stackoverflow.com/questions/4803462/jgit-java-git-library-unstaging-files
* Git repo on Amazon S3: http://stackoverflow.com/questions/8744611/git-repository-on-s3-as-origin-not-as-backup http://stackoverflow.com/questions/7031729/publish-to-s3-using-git http://www.fancybeans.com/blog/2012/08/24/how-to-use-s3-as-a-private-git-repository/
* Doing stuff without local storage: Using org.eclipse.jgit.storage.dfs.InMemoryRepository to clone a Git repo in-memory and work from there
* CherryPick
* Rebase - http://stackoverflow.com/questions/22945257/jgit-how-to-squash-commits

#### Sources

The following sources were used to build the snippets

* [JGit JavaDoc](http://download.eclipse.org/jgit/docs/latest/apidocs/)
* [JGit User Guide](http://wiki.eclipse.org/JGit/User_Guide)
* [JGit related questions on Stackoverflow](http://stackoverflow.com/questions/tagged/jgit)
* [AlBlue's Blog: Embedding JGit](http://alblue.bandlem.com/2013/11/embedding-jgit.html)
* [JGit main page](http://www.eclipse.org/jgit/)

#### Contribute

Please note that the list of snippets is not yet complete, probably never will. If you are missing things or have suggestions how to improve or add snippets, please either send pull requests or create [issues](https://github.com/centic9/jgit-cookbook/issues).

#### Licensing

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
some more text
