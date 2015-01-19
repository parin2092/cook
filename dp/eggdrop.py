'''
	k ==> Number of floors
	n ==> Number of Eggs

	eggDrop(n eggs, k floors) ==> Minimum number of trials needed to find the critical
					floor in worst case.

	eggDrop(n eggs, k floors) = 1 + min{
							max(eggDrop(eggs-1, floor - 1), eggDrop(eggs, k - floor))
						}
						floor in {1, 2, ..., k}
'''
