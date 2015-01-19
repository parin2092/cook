'''input
12
19
11111111111111
'''
import sys
class Problem:
	kmap = {0:0,1:1,2:2,3:3,4:4,5:5,6:6}
	last = 6

	def solve(self,n):
		if self.kmap.get(n,None) is not None:
			return self.kmap[n]
		else:
			for i in xrange(self.last+1,n+1):
				i2 = self.kmap.get(int(i/2),0)
				i3 = self.kmap.get(int(i/3),0)
				i4 = self.kmap.get(int(i/4),0)
				self.kmap[i] = max(i,i2+i3+i4)

			n2 = self.kmap.get(int(n/2))
			n3 = self.kmap.get(int(n/3))
			n4 = self.kmap.get(int(n/4))
			self.last = n
			self.kmap[n] = max(n,n2+n3+n4)
			return self.kmap[n]

p = Problem()

for line in sys.stdin:
	print p.solve(int(line))

'''
f(n) = max(n,f(n/2)+f(n/3)+f(n/4))
'''
