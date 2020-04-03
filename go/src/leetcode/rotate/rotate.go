package main

import "fmt"

func rotate(nums []int, k int)  {
	length := len(nums)
	if length <= 1 {
		return
	}
	k = k % length
	if k != 0 {
		reserve(nums, 0, length-k)
		reserve(nums, length - k, length)
		reserve(nums, 0, length)
	}
}

func reserve(nums []int, first int, last int) {
	last = last - 1
	for first < last {
		nums[first], nums[last] = nums[last], nums[first]
		first += 1
		last -= 1
	}
}

func main() {
	nums :=[]int{1,2,3,4,5,6,7}
	fmt.Println(nums)
	rotate(nums, 3)
	fmt.Println(nums)

}
