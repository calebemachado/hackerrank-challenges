Just to clarify some things that I needed to understand first:

- An array can have multiple zig zag sequences;
- The zig zag sequence described by the problem is a specific one:

  - A sequence will be called a zig zag sequence if the first elements in the sequence are in increasing order and the last elements are in decreasing order, but we have different zig zag sequences (that makes more sense that this one for instance)
  - A Zig Zag Sequence, also known as a "Zigzag sequence" or "Zigzag permutation," **CAN BE TOO**: a sequence of numbers that alternates between rising and falling. In other words, the elements in the sequence are arranged in such a way that they first increase and then decrease, **or vice versa**. So it can be a rising or falling

    ```code for the above mentioned zig zag sequence:
    To find the Zig Zag Sequence of the array [2, 3, 5, 1, 4], you'll need to sort the array in a special way.

    Here are the steps:

        Sort the Array in Increasing Order:
            Sort the original array in ascending order.
            The sorted array will be: [1, 2, 3, 4, 5].

        Rearrange the Sorted Array:

            Take the first three elements: [1, 2, 3].

            Reverse their order to get: [3, 2, 1].

            Take the next two elements: [4, 5].

            Reverse their order to get: [5, 4].

            Concatenate the two reversed subarrays to get the Zig Zag Sequence: [3, 2, 1, 5, 4].

    So, for the original array [2, 3, 5, 1, 4], the Zig Zag Sequence is [3, 2, 1, 5, 4].
    ```

- The example that the description gave us is a little tricky, because, [2, 3, 5, 1, 4] to become [1, 4, 5, 3, 2] is in fact a zig zag sequence, but it is not the **lexicographically smallest** one. And this made me confuse about the algorith solution.
