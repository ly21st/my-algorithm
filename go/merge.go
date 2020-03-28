package main

import (
	"fmt"
)

func merge(nums1 []int, m int, nums2 []int, n int)  {
	if n == 0 {
		return
	}
	if (m == 0) {
		for n > 0 {
			nums1[n-1] = nums2[n-1]
			n -= 1
		}
		return
	}
	cur := m + n
	for m > 0 && n > 0 {
		if nums1[m-1] <= nums2[n-1] {
			nums1[cur-1] = nums2[n-1]
			n -= 1
		} else {
			nums1[cur-1] = nums1[m-1]
			m = m - 1
		}
		cur -= 1
	}
	for n > 0 {
		nums1[cur-1] = nums2[n-1]
		n -= 1
		cur -= 1
	}

}


func print(nums []int) {
	for _, i := range(nums) {
		fmt.Printf("%d ", i)
	}
}
func main() {
	//nums1 := []int{1,2,3,0,0,0}
	//nums2 := []int{2,5,6}
	nums1 := []int{0}
	nums2 := []int{1}
	merge(nums1, 0, nums2, 1)
	print(nums1)
}
