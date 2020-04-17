# RESTberry-(a)pi
A RESTful service that calculates prime numbers and more, which you can run on
your Raspberry Pi.

## Scripts (Linux / Unix)
Clean Gradle build directory, and run tests:

    ./gradlew clean test

Clean Gradle build directory, and run the application:

    ./gradlew clean bootRun

Test caching by running the following command twice:

    time curl localhost:8080/primes/10000000 | tail -c 10
(The second execution should be significantly faster.)

## Deploying the application with Ansible
NOTE: For now, this is meant for deploying to a local test machine only.

Terminology:
- Control node: the machine from which the Ansible playbook is run.
- Managed node: server that is managed by Ansible.

Prerequisites:
- Ansible should be installed on the control node.
- A running debian machine that will function as the managed node.
- An ssh configuration on the control node, such that the managed node can be
  accessed with `ssh algorithm-service`. After running this command, you should
  be logged in as a user with sudo privileges.

To deploy the application, run the following command:

    (cd ansible && ansible-playbook playbook.yml --ask-become)
You will be prompted for the sudo password of the managed node user.
