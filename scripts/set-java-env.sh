#echo "List all java sdk found in your system"
#/usr/libexec/java_home -V

export JAVA_8_HOME=$(/usr/libexec/java_home -v 1.8)
export JAVA_11_HOME=$(/usr/libexec/java_home -v 11.0)
export JAVA_13_HOME=$(/usr/libexec/java_home -v 13.0)

# set java jdk env
alias set-java8='export JAVA_HOME=$JAVA_8_HOME'
alias set-java11='export JAVA_HOME=$JAVA_11_HOME'
alias set-java13='export JAVA_HOME=$JAVA_13_HOME'