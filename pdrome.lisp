(defun palindromep(myList)
	(cond
	((null myList) t)
	((equal (first myList) (first(reverse myList))) (palindromep(rest(reverse(rest myList)))))
	
	  ))

(write(palindromep '(a b b a)))
(terpri)
(write(palindromep '(a b c b a)))
(terpri)
(write(palindromep '(a b c)))
(terpri)
(write(palindromep '(a (d e) b (d e) a)))
(terpri)
(write(palindromep '(a (d e) b (e d) a)))

	
