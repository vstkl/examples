arrays = [
    [0],
    [1,4,6],
    [2,5,6],
    [1,2,6],
    [2,3,5,1,7],
]


def merge(arrays):

    # 1D array to store results
    res = []

    # Iterate through arrays
    for array in arrays:

        # Each item must be assigned position
        for item in array:

            # Running backwards to have min to max order
            index = len(res)

            # Assign first item
            if index == 0:
                res.insert(index, item)

            while index > 0:

                # Since n-1'th member is compared to item in array, lowering the index is in place
                index = index - 1
                if res[index] <= item:
                    res.insert(index + 1, item)
                    break
    return res

proof = merge(arrays)

control = [0, 1, 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 6, 6, 7]
assert control == proof, Merging was unnsuccessful

print(Merged succesfully)
