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
    # O(m. * n)

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


def topKFrequent(nums: [int], k: int) -> [int]:
    repeated = {}
    for i, num in enumerate(nums):
        repeated[num] = 1 + repeated.get(num, 0)

    bucket = [[] for i in range(len(nums) + 1)]
    for key, value in repeated.items():
        bucket[value].append(key)

    res = []
    for i in range(len(bucket) - 1, 0, -1):
        for n in bucket[i]:
            res.append(n)
            if len(res) == k:
                return res


def productExceptSelf(nums: [int]) -> [int]:
    # 1st solution
    result = [0 for _ in range(len(nums))]

    pre = 1
    for i in range(0, len(nums), 1):
        result[i] = pre
        pre *= nums[i]

    post = 1
    for i in range(len(nums) - 1, -1, -1):
        result[i] *= post
        post *= nums[i]

    return result

    # 2nd solution
    prefix = [0 for _ in range(len(nums))]
    postfix = [0 for _ in range(len(nums))]
    result = [0 for _ in range(len(nums))]

    for i in range(0, len(nums), 1):
        if (i == 0):
            prefix[i] = nums[i]
        else:
            prefix[i] = nums[i] * prefix[i - 1]

    for i in range(len(nums) - 1, -1, -1):
        if (i == len(nums) - 1):
            postfix[i] = nums[i]
        else:
            postfix[i] = nums[i] * postfix[i + 1]

    for i in range(0, len(nums), 1):
        if i == 0:
            result[i] = postfix[i + 1]
        elif i == len(nums) - 1:
            result[i] = prefix[i - 1]
        else:
            result[i] = prefix[i - 1] * postfix[i + 1]

    print(prefix)
    print(postfix)
    print(result)

    return result


# print(containsDuplicate([1, 1, 2, 2, 4, 5]))
# print(twoSum([2, 7, 11, 15], 9))
# print(groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
print(productExceptSelf([1, 2, 3, 4]))
