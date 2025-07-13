def isPalindrome(palindrome, checkFrom):
    if (checkFrom == len(palindrome) // 2):
        return True
    else:
        if (palindrome[checkFrom] != palindrome[-1-checkFrom]):
            return False
        else:
            return isPalindrome(palindrome, checkFrom+1)

print("Enter a Palindrome:")
palindrome = input()
print(isPalindrome(palindrome, 0))