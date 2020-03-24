CWD="$(pwd)"
source "$CWD/scripts/set-java-env.sh"
set-java13
./mvnw clean install spring-boot:run
