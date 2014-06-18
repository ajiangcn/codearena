package leetCode

import org.scalatest.FunSuite

class PalindromePartitioningIITest extends FunSuite {

  test("test longest palindrome ") {
    val solution = new PalindromePartitioningII();
    assert("aaaaa" === solution.findTheLongestPalindrome("aaaaa"))
  }

  test("test min cut") {
    val solution = new PalindromePartitioningII();
    assert(1 === solution.minCut("caba"))
    assert(7 === solution.minCut("abacdfgdcaba"))
    assert(2 === solution.minCut("leet"))
    assert(2 === solution.minCut("leeteet"))
    assert(25 === solution.minCut("abcdefghigklmnopqrstuvwxyz"))
    assert(25 === solution.minCut("aabcdefghigklmnopqrstuvwxyz"))
    assert(24 === solution.minCut("aabcdeeffghigklmnopqrstuvwxzzyyzz"))
    assert(25 === solution.minCut("abcdefghigklmnmnopqrstuvwxyz"))
    //assert(452 === solution.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"))
  }
}
