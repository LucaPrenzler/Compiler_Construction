This was a practical given by the University Of Pretoria

This program demonstrates the basic workings of a compiler. 
Thus it demonstrates the lexar and the parser.
This program uses a student programming language provided in the pdf's 
Explanation of Lexar and Explanation of the Parser 

the input.txt is an example program of the student programming language 

To Run 
Open in any java environment of your choice and run the Main.java file. 

Expected output: 
LinkedList: 
T0      Token Class: Special command    Input snippet: halt        
T1      Token Class: Grouping symbol    Input snippet: ;
T2      Token Class: Procedure definition       Input snippet: proc
T3      Token Class: Variable   Input snippet: myprocedure
T4      Token Class: Grouping symbol    Input snippet: {
T5      Token Class: Special command    Input snippet: halt        
T6      Token Class: Grouping symbol    Input snippet: ;
T7      Token Class: Procedure definition       Input snippet: proc
T8      Token Class: Variable   Input snippet: myprocedure2        
T9      Token Class: Grouping symbol    Input snippet: {
T10     Token Class: Variable   Input snippet: myprocedure2        
T11     Token Class: Grouping symbol    Input snippet: ;
T12     Token Class: Special command    Input snippet: halt        
T13     Token Class: Grouping symbol    Input snippet: }
T14     Token Class: Grouping symbol    Input snippet: }
T15     Token Class: Procedure definition       Input snippet: proc
T16     Token Class: Variable   Input snippet: myprocedure3        
T17     Token Class: Grouping symbol    Input snippet: {
T18     Token Class: Special command    Input snippet: halt        
T19     Token Class: Grouping symbol    Input snippet: ;
T20     Token Class: Variable   Input snippet: myprocedure2        
T21     Token Class: Grouping symbol    Input snippet: ;
T22     Token Class: Procedure definition       Input snippet: proc
T23     Token Class: Variable   Input snippet: myprocedure2
T24     Token Class: Grouping symbol    Input snippet: {
T25     Token Class: Special command    Input snippet: halt
T26     Token Class: Grouping symbol    Input snippet: ;
T27     Token Class: Procedure definition       Input snippet: proc
T28     Token Class: Variable   Input snippet: myprocedure4
T29     Token Class: Grouping symbol    Input snippet: {
T30     Token Class: Special command    Input snippet: halt
T31     Token Class: Grouping symbol    Input snippet: ;
T32     Token Class: Procedure definition       Input snippet: proc
T33     Token Class: Variable   Input snippet: myprocedure5
T34     Token Class: Grouping symbol    Input snippet: {
T35     Token Class: Variable   Input snippet: myprocedure5
T36     Token Class: Grouping symbol    Input snippet: ;
T37     Token Class: Special command    Input snippet: halt
T38     Token Class: Grouping symbol    Input snippet: }
T39     Token Class: Grouping symbol    Input snippet: }
T40     Token Class: Grouping symbol    Input snippet: }
T41     Token Class: Grouping symbol    Input snippet: }
T42     Token Class: Procedure definition       Input snippet: proc
T43     Token Class: Variable   Input snippet: myprocedure6
T44     Token Class: Grouping symbol    Input snippet: {
T45     Token Class: Special command    Input snippet: halt
T46     Token Class: Grouping symbol    Input snippet: ;
T47     Token Class: Procedure definition       Input snippet: proc
T48     Token Class: Variable   Input snippet: myprocedure7
T49     Token Class: Grouping symbol    Input snippet: {
T50     Token Class: Special command    Input snippet: halt
T51     Token Class: Grouping symbol    Input snippet: ;
T52     Token Class: Variable   Input snippet: myprocedure2
T53     Token Class: Grouping symbol    Input snippet: ;
T54     Token Class: Procedure definition       Input snippet: proc
T55     Token Class: Variable   Input snippet: myprocedure2
T56     Token Class: Grouping symbol    Input snippet: {
T57     Token Class: Special command    Input snippet: halt
T58     Token Class: Grouping symbol    Input snippet: ;
T59     Token Class: Procedure definition       Input snippet: proc
T60     Token Class: Variable   Input snippet: myprocedure4
T61     Token Class: Grouping symbol    Input snippet: {
T62     Token Class: Special command    Input snippet: halt
T63     Token Class: Grouping symbol    Input snippet: ;
T64     Token Class: Procedure definition       Input snippet: proc
T65     Token Class: Variable   Input snippet: myprocedure5
T66     Token Class: Grouping symbol    Input snippet: {
T67     Token Class: Variable   Input snippet: myprocedure5
T68     Token Class: Grouping symbol    Input snippet: ;
T69     Token Class: Special command    Input snippet: halt
T70     Token Class: Grouping symbol    Input snippet: ;
T71     Token Class: Procedure definition       Input snippet: proc
T72     Token Class: Variable   Input snippet: myprocedure12
T73     Token Class: Grouping symbol    Input snippet: {
T74     Token Class: Special command    Input snippet: halt
T75     Token Class: Grouping symbol    Input snippet: ;
T76     Token Class: Procedure definition       Input snippet: proc
T77     Token Class: Variable   Input snippet: myprocedure20
T78     Token Class: Grouping symbol    Input snippet: {
T79     Token Class: Special command    Input snippet: halt
T80     Token Class: Grouping symbol    Input snippet: ;
T81     Token Class: Procedure definition       Input snippet: proc
T82     Token Class: Variable   Input snippet: myprocedure21
T83     Token Class: Grouping symbol    Input snippet: {
T84     Token Class: Variable   Input snippet: myprocedure21
T85     Token Class: Grouping symbol    Input snippet: ;
T86     Token Class: Special command    Input snippet: halt
T87     Token Class: Grouping symbol    Input snippet: }
T88     Token Class: Grouping symbol    Input snippet: }
T89     Token Class: Grouping symbol    Input snippet: }
T90     Token Class: Grouping symbol    Input snippet: }
T91     Token Class: Grouping symbol    Input snippet: }
T92     Token Class: Grouping symbol    Input snippet: }
T93     Token Class: Grouping symbol    Input snippet: }
T94     Token Class: Grouping symbol    Input snippet: }
T95     Token Class: End        Input snippet: $

SUCCESS !!!
Num: 0 Value: Start Parent null NumOf children: 2
Num: 1 Value: PROG Parent Start NumOf children: 3
Num: 2 Value: CODE Parent PROG NumOf children: 1
Num: 3 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 4 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 5 Value: ; Parent PROG NumOf children: 0
Num: 6 Value: PROC Parent PROG NumOf children: 6
Num: 7 Value: proc Parent PROC NumOf children: 0
Num: 8 Value: myprocedure Parent PROC NumOf children: 0
Num: 9 Value: { Parent PROC NumOf children: 0
Num: 10 Value: PROG Parent PROC NumOf children: 3
Num: 11 Value: CODE Parent PROG NumOf children: 1
Num: 12 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 13 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 14 Value: ; Parent PROG NumOf children: 0
Num: 15 Value: PROC Parent PROG NumOf children: 6
Num: 16 Value: proc Parent PROC NumOf children: 0
Num: 17 Value: myprocedure2 Parent PROC NumOf children: 0
Num: 18 Value: { Parent PROC NumOf children: 0
Num: 19 Value: PROG Parent PROC NumOf children: 1
Num: 20 Value: CODE Parent PROG NumOf children: 3
Num: 21 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 22 Value: CALL Parent INSTRUCTION NumOf children: 1
Num: 23 Value: myprocedure2 Parent CALL NumOf children: 0
Num: 24 Value: ; Parent CODE NumOf children: 0
Num: 25 Value: CODE Parent CODE NumOf children: 1
Num: 26 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 27 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 28 Value: } Parent PROC NumOf children: 0
Num: 29 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 30 Value: } Parent PROC NumOf children: 0
Num: 31 Value: PROG_DEFINITION Parent PROC NumOf children: 1
Num: 32 Value: PROC Parent PROG_DEFINITION NumOf children: 6
Num: 33 Value: proc Parent PROC NumOf children: 0
Num: 34 Value: myprocedure3 Parent PROC NumOf children: 0
Num: 35 Value: { Parent PROC NumOf children: 0
Num: 36 Value: PROG Parent PROC NumOf children: 3
Num: 37 Value: CODE Parent PROG NumOf children: 3
Num: 38 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 39 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 40 Value: ; Parent CODE NumOf children: 0
Num: 41 Value: CODE Parent CODE NumOf children: 1
Num: 42 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 43 Value: CALL Parent INSTRUCTION NumOf children: 1
Num: 44 Value: myprocedure2 Parent CALL NumOf children: 0
Num: 45 Value: ; Parent PROG NumOf children: 0
Num: 46 Value: PROC Parent PROG NumOf children: 6
Num: 47 Value: proc Parent PROC NumOf children: 0
Num: 48 Value: myprocedure2 Parent PROC NumOf children: 0
Num: 49 Value: { Parent PROC NumOf children: 0
Num: 50 Value: PROG Parent PROC NumOf children: 3
Num: 51 Value: CODE Parent PROG NumOf children: 1
Num: 52 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 53 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 54 Value: ; Parent PROG NumOf children: 0
Num: 55 Value: PROC Parent PROG NumOf children: 6
Num: 56 Value: proc Parent PROC NumOf children: 0
Num: 57 Value: myprocedure4 Parent PROC NumOf children: 0
Num: 58 Value: { Parent PROC NumOf children: 0
Num: 59 Value: PROG Parent PROC NumOf children: 3
Num: 60 Value: CODE Parent PROG NumOf children: 1
Num: 61 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 62 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 63 Value: ; Parent PROG NumOf children: 0
Num: 64 Value: PROC Parent PROG NumOf children: 6
Num: 65 Value: proc Parent PROC NumOf children: 0
Num: 66 Value: myprocedure5 Parent PROC NumOf children: 0
Num: 67 Value: { Parent PROC NumOf children: 0
Num: 68 Value: PROG Parent PROC NumOf children: 1
Num: 69 Value: CODE Parent PROG NumOf children: 3
Num: 70 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 71 Value: CALL Parent INSTRUCTION NumOf children: 1
Num: 72 Value: myprocedure5 Parent CALL NumOf children: 0
Num: 73 Value: ; Parent CODE NumOf children: 0
Num: 74 Value: CODE Parent CODE NumOf children: 1
Num: 75 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 76 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 77 Value: } Parent PROC NumOf children: 0
Num: 78 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 79 Value: } Parent PROC NumOf children: 0
Num: 80 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 81 Value: } Parent PROC NumOf children: 0
Num: 82 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 83 Value: } Parent PROC NumOf children: 0
Num: 84 Value: PROG_DEFINITION Parent PROC NumOf children: 1
Num: 85 Value: PROC Parent PROG_DEFINITION NumOf children: 6
Num: 86 Value: proc Parent PROC NumOf children: 0
Num: 87 Value: myprocedure6 Parent PROC NumOf children: 0
Num: 88 Value: { Parent PROC NumOf children: 0
Num: 89 Value: PROG Parent PROC NumOf children: 3
Num: 90 Value: CODE Parent PROG NumOf children: 1
Num: 91 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 92 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 93 Value: ; Parent PROG NumOf children: 0
Num: 94 Value: PROC Parent PROG NumOf children: 6
Num: 95 Value: proc Parent PROC NumOf children: 0
Num: 96 Value: myprocedure7 Parent PROC NumOf children: 0
Num: 97 Value: { Parent PROC NumOf children: 0
Num: 98 Value: PROG Parent PROC NumOf children: 3
Num: 99 Value: CODE Parent PROG NumOf children: 3
Num: 100 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 101 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 102 Value: ; Parent CODE NumOf children: 0
Num: 103 Value: CODE Parent CODE NumOf children: 1
Num: 104 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 105 Value: CALL Parent INSTRUCTION NumOf children: 1
Num: 106 Value: myprocedure2 Parent CALL NumOf children: 0
Num: 107 Value: ; Parent PROG NumOf children: 0
Num: 108 Value: PROC Parent PROG NumOf children: 6
Num: 109 Value: proc Parent PROC NumOf children: 0
Num: 110 Value: myprocedure2 Parent PROC NumOf children: 0
Num: 111 Value: { Parent PROC NumOf children: 0
Num: 112 Value: PROG Parent PROC NumOf children: 3
Num: 113 Value: CODE Parent PROG NumOf children: 1
Num: 114 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 115 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 116 Value: ; Parent PROG NumOf children: 0
Num: 117 Value: PROC Parent PROG NumOf children: 6
Num: 118 Value: proc Parent PROC NumOf children: 0
Num: 119 Value: myprocedure4 Parent PROC NumOf children: 0
Num: 120 Value: { Parent PROC NumOf children: 0
Num: 121 Value: PROG Parent PROC NumOf children: 3
Num: 122 Value: CODE Parent PROG NumOf children: 1
Num: 123 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 124 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 125 Value: ; Parent PROG NumOf children: 0
Num: 126 Value: PROC Parent PROG NumOf children: 6
Num: 127 Value: proc Parent PROC NumOf children: 0
Num: 128 Value: myprocedure5 Parent PROC NumOf children: 0
Num: 129 Value: { Parent PROC NumOf children: 0
Num: 130 Value: PROG Parent PROC NumOf children: 3
Num: 131 Value: CODE Parent PROG NumOf children: 3
Num: 132 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 133 Value: CALL Parent INSTRUCTION NumOf children: 1
Num: 134 Value: myprocedure5 Parent CALL NumOf children: 0
Num: 135 Value: ; Parent CODE NumOf children: 0
Num: 136 Value: CODE Parent CODE NumOf children: 1
Num: 137 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 138 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 139 Value: ; Parent PROG NumOf children: 0
Num: 140 Value: PROC Parent PROG NumOf children: 6
Num: 141 Value: proc Parent PROC NumOf children: 0
Num: 142 Value: myprocedure12 Parent PROC NumOf children: 0
Num: 143 Value: { Parent PROC NumOf children: 0
Num: 144 Value: PROG Parent PROC NumOf children: 3
Num: 145 Value: CODE Parent PROG NumOf children: 1
Num: 146 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 147 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 148 Value: ; Parent PROG NumOf children: 0
Num: 149 Value: PROC Parent PROG NumOf children: 6
Num: 150 Value: proc Parent PROC NumOf children: 0
Num: 151 Value: myprocedure20 Parent PROC NumOf children: 0
Num: 152 Value: { Parent PROC NumOf children: 0
Num: 153 Value: PROG Parent PROC NumOf children: 3
Num: 154 Value: CODE Parent PROG NumOf children: 1
Num: 155 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 156 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 157 Value: ; Parent PROG NumOf children: 0
Num: 158 Value: PROC Parent PROG NumOf children: 6
Num: 159 Value: proc Parent PROC NumOf children: 0
Num: 160 Value: myprocedure21 Parent PROC NumOf children: 0
Num: 161 Value: { Parent PROC NumOf children: 0
Num: 162 Value: PROG Parent PROC NumOf children: 1
Num: 163 Value: CODE Parent PROG NumOf children: 3
Num: 164 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 165 Value: CALL Parent INSTRUCTION NumOf children: 1
Num: 166 Value: myprocedure21 Parent CALL NumOf children: 0
Num: 167 Value: ; Parent CODE NumOf children: 0
Num: 168 Value: CODE Parent CODE NumOf children: 1
Num: 169 Value: INSTRUCTION Parent CODE NumOf children: 1
Num: 170 Value: halt Parent INSTRUCTION NumOf children: 0
Num: 171 Value: } Parent PROC NumOf children: 0
Num: 172 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 173 Value: } Parent PROC NumOf children: 0
Num: 174 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 175 Value: } Parent PROC NumOf children: 0
Num: 176 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 177 Value: } Parent PROC NumOf children: 0
Num: 178 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 179 Value: } Parent PROC NumOf children: 0
Num: 180 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 181 Value: } Parent PROC NumOf children: 0
Num: 182 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 183 Value: } Parent PROC NumOf children: 0
Num: 184 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 185 Value: } Parent PROC NumOf children: 0
Num: 186 Value: PROG_DEFINITION Parent PROC NumOf children: 0
Num: 187 Value: $ Parent Start NumOf children: 0