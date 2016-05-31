#Horatiu Lazu
#HackerRank

#We promptly judged antique ivory buckles for the next prize 
#We promptly judged antique ivory buckles for the prize

s = raw_input().lower()
count = 0
vis = [None]*26
for x  in range(0, 26):
	vis[x] = False
for x in range(0, len(s)):
	if s[x] != ' ' and vis[ord(s[x]) - ord('a')] == False:
		vis[ord(s[x]) - ord('a')] = True
		count = count+1
if (count == 26):
	print "pangram"
else:
	print "not pangram"
	
	