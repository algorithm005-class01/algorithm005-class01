#解法1：哈希表，用质数避免哈希碰撞
class Solution(object):
    def __init__(self):
        self.primes =[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101]

    def caculate_hash(self,str):
        result = 1
        for each in str:
            result = result * self.primes[ord(each)-ord('a')]
        
        return result


    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        sol = []
        hash_value = {}
        if strs is None:
            return None
        for each in strs:
            if each == None:
                continue
            hash = self.caculate_hash(each)
            if hash in hash_value:
                hash_value[hash].append(each)
            else:
                hash_value[hash] = [each]
        
        for k,v in hash_value.items():
            sol.append(v)
        return sol

#解法2：排序法
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        hashmap ={}
        for s in strs:
            key = "".join(sorted(s))
            if key not in hashmap:
                hashmap[key] = [s]
            else:
                hashmap[key] += [s]

        return hashmap.values()
