package data_structures.arrays

import org.scalatest.flatspec.AnyFlatSpec
import data_structures.arrays.Problem01_06.rotationCipher

class Problem01_06Specs extends AnyFlatSpec {

  "rotation cipher" should "work for given test cases" in {

    assert(rotationCipher("Zebra-493?", 3) ==
      "Cheud-726?")

    assert(rotationCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39) ==
      "nopqrstuvwxyzABCDEFGHIJKLM9012345678")

  }
}
