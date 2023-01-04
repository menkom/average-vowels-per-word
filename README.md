 ## Have:
 English words from text file (INPUT.TXT), separated with punctuation and at least one whitespace 

 ## Determine:
Average number of vowels per word grouped by 
1) set of vowels in a word
2) and length of the word

## Assumptions:
1. Capital and lower case letter should be treated as the same.
2. Input contains only English words and punctuation, words are separated by at least one whitespace character.
3. Input is small enough to fit in memory.
4. If any additional assumptions about input\output are made, they should be stated in comments/email.

## Example:

INPUT
```
Platon made bamboo boats.
```

OUTPUT
```
({a, o}, 6) -> 2.5
({a, o}, 5) -> 2
({a, e}, 4) -> 2
```
## Thoughts during development

1. According to task description we have INPUT.TXT text file. 
   * Name is INPUT.TXT
   * It is text
2. Nothing about number of lines or line separator so we can start from one line and after extend solution to several
3. Expect that there is no word hyphenation
4. Can go char by char from the beginning analyzing but this mean O(n) complexity. Is any other solution? What about regex? Regex split use `while` under the hood. So no point to use regex as this will need even more then O(n) 
5. ~~Words can be extracted using whitespaces and punctuations as separators.~~ Replacing punctuation to whitespace and further processing again need more time.
6. ~~Do words without vowels need special attention?~~ No special attention in current realization
7. ~~What about empty line? Keep this case in mind~~ All is fine using current approach.
8. Dependency Injection can be added but don't see the need of doing this at current stage without info about further plans of project.
9. Process can be slightly accelerated with use of multithreading. After reading each line processing of each line can be done in separate thread. In this case method and collection of results have to be threadsafe.
10. Was no info about the result rounding up.


## Instructions to use
1. This command line application. You can run it with IDE or use simple command line
2. Expected that input file is placed next to jar file and has name INPUT.TXT. (There is option to use file with different name)
3. If we start application from IDE file have to be in root folder of project (It is placed in correct place in source now).
4. If we run program from command line using `java -jar average-vowels-per-word-1.0-SNAPSHOT.jar` then file INPUT.TXT have to be next to jar file.