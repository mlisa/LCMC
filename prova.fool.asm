push 0

lfp
push append2
lfp
push printList3
lfp
push filter5
lfp
push quicksort6
lfp
push inc9
lfp
push dec10
push 2
push 1
push 4
push 3
push 2
push 5
push 6
push -1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lfp
lfp
push -10
lfp
add
lw
push -11
lfp
add
lw
push -14
lfp
add
lw
push -8
lfp
add
lw
push -9
lfp
add
lw
js
push -4
lfp
add
lw
push -5
lfp
add
lw
js
halt

first0:
cfp
lra
push -1
lfp
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

rest1:
cfp
lra
push -2
lfp
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

append2:
cfp
lra
push 1
lfp
add
lw
push -1
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 0
add
lw
js
lfp
push 2
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lw
js
push -2
lfp
lw
add
lw
push -3
lfp
lw
add
lw
js
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
b label1
label0:
push 2
lfp
add
lw
label1:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

makeList4:
cfp
lra
push 2
lfp
add
lw
push 1
lfp
add
lw
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
srv
sra
pop
pop
pop
sfp
lrv
lra
js

printList3:
cfp
lra
lfp
push makeList4
push 1
lfp
add
lw
push -1
beq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
lfp
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 0
add
lw
js
print
lfp
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lw
js
push -4
lfp
lw
add
lw
push -5
lfp
lw
add
lw
js
push -2
lfp
add
lw
push -3
lfp
add
lw
js
b label5
label4:
push -1
label5:
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js

filter5:
cfp
lra
push 1
lfp
add
lw
push -1
beq label10
push 0
b label11
label10:
push 1
label11:
push 1
beq label8
lfp
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 0
add
lw
js
push 3
lfp
add
lw
push 2
lfp
add
lw
js
push 1
beq label12
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lw
js
push -6
lfp
lw
add
lw
push -7
lfp
lw
add
lw
js
b label13
label12:
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 0
add
lw
js
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lw
js
push -6
lfp
lw
add
lw
push -7
lfp
lw
add
lw
js
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
label13:
b label9
label8:
push -1
label9:
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js

beforePivot7:
cfp
lra
lfp
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
push 3
lfp
lw
add
lw
push 2
lfp
lw
add
lw
js
srv
sra
pop
pop
sfp
lrv
lra
js

afterPivot8:
cfp
lra
lfp
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
push 3
lfp
lw
add
lw
push 2
lfp
lw
add
lw
js
push 1
beq label18
push 1 
b label19
label18:
push 0 
label19:
srv
sra
pop
pop
sfp
lrv
lra
js

quicksort6:
cfp
lra
push 1
lfp
add
lw
push -1
beq label16
push 0
b label17
label16:
push 1
label17:
push 1
beq label14
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 0
add
lw
js
b label15
label14:
push 0
label15:
lfp
push beforePivot7
lfp
push afterPivot8
push 1
lfp
add
lw
push -1
beq label22
push 0
b label23
label22:
push 1
label23:
push 1
beq label20
lfp
push -2
lfp
add
lw
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw
lfp
push -5
lfp
add
lw
push -6
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lw
js
push -6
lfp
lw
add
lw
push -7
lfp
lw
add
lw
js
push -8
lfp
lw
add
lw
push -9
lfp
lw
add
lw
js
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push first0
lhp
sw
lhp
push 1
add
shp
push rest1
lhp
sw
lhp
push 1
add
shp
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw
lfp
push -3
lfp
add
lw
push -4
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lw
js
push -6
lfp
lw
add
lw
push -7
lfp
lw
add
lw
js
push -8
lfp
lw
add
lw
push -9
lfp
lw
add
lw
js
push -2
lfp
lw
add
lw
push -3
lfp
lw
add
lw
js
b label21
label20:
push -1
label21:
srv
pop
pop
pop
pop
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js

inc9:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
bleq label24
push 0
b label25
label24:
push 1
label25:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

dec10:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
beq label26
push 1
lfp
add
lw
push 2
lfp
add
lw
bleq label27
label26:
push 1
b label28
label27:
push 0
label28:
srv
sra
pop
pop
pop
sfp
lrv
lra
js
