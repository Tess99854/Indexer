# Indexer
### Introduction 
This service provides a simple information retrieval system based on Inverted indexation, thus allowing a fast and efficient search of terms in specified files or directories.

The indexing process goes through 3 different phases:

1. **Tokenization**: 
Where the content of the files is transformed into tokens, normalized and cleaned using a pre-defined extendable stopWords list. 

2. **Stemming**: 
Derived words are reduced to their word stem.

3. **Mapping**: 
Map every word to its location (file path) and state the number of its occurences 

### Usage Examples
###### First example:
Using a directory's path:
``` 
paths: src/ressources/Mathematics
search word: algorithms 
```
Result: 
```
[C:\Users\tesnime\IdeaProjects\Indexer\src\ressources\Mathematics\analysis = 3]
```

###### First example:
Using multiple paths:
``` 
paths: src/ressources/Mathematics/analysis src/ressources/Mathematics/cryptography
search word: algorithms 
```
Result: 
```
[C:\Users\tesnime\IdeaProjects\Indexer\src\ressources\Mathematics\analysis = 3]
```
