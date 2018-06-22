# Contact List

...

# Getting started
- Make sure Java is installed
- Install gradle
- One person on your team should fork the repository
- Clone that forked repository to your local machine
- Create a new branch. If you are "foo@mills.edu", create a "foo-development" branch thusly: "git checkout -b foo-development"
- run `gradle test` from the contactlist directory
  - Observe "BUILD SUCCESSFUL in 1s"
  - This means that gradle works, and the code compiles and runs all unit tests cleanly
- You're ready to begin.
- Read up on how the code is structured.

# Running the app
- gradle installDist
- `./build/install/contactlist/bin/contactlist -impl ArrayContactList -inputfile foo`
