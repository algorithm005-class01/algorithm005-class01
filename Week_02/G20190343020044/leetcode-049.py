class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        wordmap = {}
        for word in strs:
            sorted_word = "".join(sorted(word))
            if sorted_word not in wordmap.keys():
                wordmap[sorted_word] = [word]
            else:
                wordmap[sorted_word].append(word)
        return wordmap.values()