def containsDuplicate(nums) -> bool:
    nums.sort()
    repeated = {}
    for i in nums:
        if i in repeated:
            return True
        else:
            repeated[i] = True
    return False


def twoSum(nums, target: int) -> [int]:
    for i, item in enumerate(nums):
        j = i + 1
        while j < len(nums):
            if nums[i] + nums[j] == target:
                return [i, j]
            j += 1

def groupAnagrams(strs: [str]) -> [[str]]:
        res = defaultdict(list)
        for s in strs:
            count = [0] * 26

            for c in s:
                count[ord(c) - ord("a")] += 1
            
            res[tuple(count)].append(s)
        
        return res.values()
        #O(m. * n)

        result = {}
        for i, item in enumerate(strs):
            anagram = ''.join(sorted(item))
            if anagram in result:
                anagram_list = result[anagram]
                anagram_list.append(item)
                result[anagram] = anagram_list
            else:
                data = []
                data.append(item)
                result[anagram] = data
        
        resp = []
        for item in result:
            resp.append(result[item])
        
        return resp


# print(containsDuplicate([1, 1, 2, 2, 4, 5]))
# print(twoSum([2, 7, 11, 15], 9))
print(groupAnagrams(["eat","tea","tan","ate","nat","bat"]))