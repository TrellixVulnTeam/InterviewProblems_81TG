package leetcode

/* Problem 1333.

Filter Restaurants by Vegan-Friendly, Price and Distance

Given the array restaurants where  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]. You have to
filter the restaurants using three filters.

The veganFriendly filter will be either true (meaning you should only include restaurants with veganFriendlyi set to
true) or false (meaning you can include any restaurant). In addition, you have the filters maxPrice and maxDistance
which are the maximum value for price and distance of restaurants you should consider respectively.

Return the array of restaurant IDs after filtering, ordered by rating from highest to lowest. For restaurants with the
same rating, order them by id from highest to lowest. For simplicity veganFriendlyi and veganFriendly take value 1
when it is true, and 0 when it is false.
 */

object Solution1333 {
  def filterRestaurants(restaurants: Array[Array[Int]], veganFriendly: Int, maxPrice: Int, maxDistance: Int): List[Int] = {

    val filteredRestaurants = restaurants.filter(r => {
      val veganCheck = if (veganFriendly == 1) r(2) == 1 else true
      veganCheck && r(3) <= maxPrice && r(4) <= maxDistance
    })

    filteredRestaurants.sortWith((l, r) => {
      if (l(1) == r(1))
        l(0) > r(0)
      else
        l(1) > r(1)
    })
      .map(r => r(0))
      .toList
  }
}