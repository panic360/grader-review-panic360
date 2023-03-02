CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'
NUMTEST=4
git clone $1 student-submission

cp Tester.java student-submission
cp -r lib student-submission
cd student-submission

if [[ -f ListExamples.java ]]
then
    echo "file found"
    javac ListExamples.java
    if [[ $? -ne 0 ]]
    then 
        echo "error in compiling"
    else
        javac -cp ".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar" *.java
        java -cp ".:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore Tester > test.txt
        echo $(($NUMTEST-`head -n 2 test.txt | grep -o "E" | wc -l`)) out of $NUMTEST points achieved!
        rm test.txt;
    fi
    rm -rf student-submission
else
    echo "file not found"
    exit 1
fi

echo 'Finished cloning'