SELECT A.ID, A.Name, A.AccountNo, 	
	REPLACE(CONVERT(VARCHAR,CONVERT(MONEY,((CONVERT(BIGINT, (SELECT REPLACE
		(CONVERT(MONEY,CONVERT(VARCHAR,A.OriginalBalance),1), '.00','')) ))	
		-
	(CONVERT(BIGINT, (SELECT REPLACE
		(CONVERT(MONEY,CONVERT(VARCHAR,H.HoldBalance),1), '.00','')) )))),1), '.00','')
		AS AvailableBalance		 		

FROM Account A 
INNER JOIN HoldBalance H
ON 
	A.ID = H.ID 
	AND A.AccountNo = H.AccountNo;