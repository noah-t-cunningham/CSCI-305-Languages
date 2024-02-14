        PROGRAM superSpy
                IMPLICIT NONE
                INTEGER :: hatS, hatSL, digOne, digFour, digFour2
                CHARACTER(LEN = 6) :: hS
                DO
                        WRITE(*,*) 'Hat Size?'
                        READ(*,*) hatS
                        IF (hatS >= 1000 .AND. hatS < 999999 ) THEN
                                EXIT 
                        END IF                       
                END DO
        CALL firstDigit(hatS, hatSL, digOne, digFour, digFour2)
        WRITE(*,*) "Use",digOne," ",digFour2
        END PROGRAM superSpy 
        SUBROUTINE firstDigit(hatS, hatSL, digOne, digFour, digFour2)
              IMPLICIT NONE  
              INTEGER, INTENT(IN) :: hatS, hatSL
              INTEGER, INTENT(OUT) :: digOne, digFour, digFour2 
              digOne = MOD(hatS, 10)
              digFour = MOD(hatS, 10000)
              digFour2 = digFour/ (10** 3)
        END SUBROUTINE firstDigit
