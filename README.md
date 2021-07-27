# coding-challenge

Task 1 can be found here: coding-challenge/src/main/java/com/challenge/tasks/Problem1.java (https://github.com/razvancornita/coding-challenge/blob/main/src/main/java/com/challenge/tasks/Problem1.java)

Task 2 can be found here: coding-challenge/src/main/java/com/challenge/tasks/Problem2.java (https://github.com/razvancornita/coding-challenge/blob/main/src/main/java/com/challenge/tasks/Problem2.java)

Task 3 is implemented in the coding-challenge/src/main/java/com/challenge/controller/ChallengeController.java class (https://github.com/razvancornita/coding-challenge/blob/main/src/main/java/com/challenge/controller/ChallengeController.java)

To build this project, import it as a Maven project, then, in the root location, run the 'mnv clean install' command.

The endpoint can be found at http://localhost:8080/calculatePolishExpression, and requires a RequestBody of the following type:

'''
{
  "expressions": [
    "+ + 0.5 1.5 * 4 10".
    "- 2e3 - 700 + 7 * 2 15",
    "- -1.5 * 3.1415 / -7 -2".
    "100500",
    "1 2",
    "+ 1"
  ]
}
'''
