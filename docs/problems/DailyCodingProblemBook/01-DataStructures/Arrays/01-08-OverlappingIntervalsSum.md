# Problem 1.8

## PROBLEM: Overlapping Intervals

Find the distance covered (sum) of all overlapping intervals.

## Examples:

### Case 1:
 - input: [[1,5],[2,6], [7,10], [8,12]]
 - output: 10
 - visual:

            ---------     -----------
            |       |     |         |
            | ------|--  -|----     |
            | |     | | | |   |     |
            | |     | | | |   |     |
            1 2 3 4 5 6 7 8 9 10 11 12
            --------------------------
            |    5    |+|      5    |  = 10

### Case 2:
 - input: [[1,8],[2,6],[11,12],[12,13]]
 - output: 9
 - visual:

            ---------------           ---
            |             |          |  |
            | ---------   |       ---   |
            | |       |   |      |   |  |
            | |       |   |      |   |  |
            1 2 3 4 5 6 7 8 9 10 11 12 13
            -----------------------------
            |      7      |  +   |   2  |  = 9
