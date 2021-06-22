package Strings

//This question becomes pretty simple if you just sort each word and then store it in a map. If a sorted version of our
// word is already in the map then we know its an anagram and add it to the appropriate list in our map. If it's not
// then we create a new key to check future words against and keep looking.
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        if (strs.isEmpty()) return mutableListOf<List<String>>(listOf(""))

        //this will be our return value
        val groupedAnagrams = mutableListOf<List<String>>()
        //here we'll store the sorted values of each word. The keys will be sorted words and the values will be a list of anagrams of the key
        val stringMap = mutableMapOf<String, MutableList<String>>()

        strs.forEach { word ->
            //taking each word and sorting it
            val sortedWord = word.toCharArray().sorted().toString()

            // now we check to see if our sorted word is already in the map

            // if it is then we'll simply add the unsorted (original) word to that key as a new entry to the value list
            if (stringMap.containsKey(sortedWord)) stringMap[sortedWord]!!.add(word)
            //if it's not then we create a new key with the sorted word and add the unsorted word to its value list
            else {
                val list = mutableListOf<String>()
                stringMap.put(sortedWord, list)
                stringMap[sortedWord]!!.add(word)
            }
        }

        //now we loop through our map and add each value to our return list
        stringMap.values.forEach {
            groupedAnagrams.add(it)
        }

        return groupedAnagrams
    }
}

//Happy coding!