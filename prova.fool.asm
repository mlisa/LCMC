push 0

lfp
 push function2
lfp
 push function5
lfp
 push function8
lfp
 push function11
lfp
 push function13
lfp
 push function15
push 3
push 4
push 6
push 1
push 2
push 5
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
lhp
sw
lhp
push 1
add
shp
lfp
lfp
push -14
lfp
add
lw
push -12
lfp
add
lw
push -13
lfp
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
halt

label0:
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

label1:
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

function0:
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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

function1:
cfp
lra
push 1
lfp
add
lw
push -1
beq label4
push 0
b label5
label4:
push 1
label5:
push 1
beq label2
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
lw
add
lw
push -3
lfp
lw
add
lw
js
b label3
label2:
push -1
label3:
srv
sra
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
lfp
 push function0
lfp
 push function1
lfp
push 1
lfp
add
lw
push -4
lfp
add
lw
push -5
lfp
add
lw
js
srv
pop
pop
pop
pop
sra
pop
pop
sfp
lrv
lra
js

function3:
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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

function4:
cfp
lra
push 1
lfp
add
lw
push -1
beq label8
push 0
b label9
label8:
push 1
label9:
push 1
beq label6
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
lw
add
lw
push -3
lfp
lw
add
lw
js
b label7
label6:
push -1
label7:
srv
sra
pop
pop
sfp
lrv
lra
js

function5:
cfp
lra
lfp
 push function3
lfp
 push function4
push 1
lfp
add
lw
push -1
beq label12
push 0
b label13
label12:
push 1
label13:
push 1
beq label10
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
lhp
sw
lhp
push 1
add
shp
b label11
label10:
push 2
lfp
add
lw
label11:
srv
pop
pop
pop
pop
sra
pop
pop
pop
sfp
lrv
lra
js

function6:
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
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

function7:
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
lw
add
lw
push -3
lfp
lw
add
lw
js
b label15
label14:
push -1
label15:
srv
sra
pop
pop
sfp
lrv
lra
js

function8:
cfp
lra
lfp
 push function6
lfp
 push function7
push 1
lfp
add
lw
push -1
beq label20
push 0
b label21
label20:
push 1
label21:
push 1
beq label18
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
push 2
lfp
add
lw
push 1
lfp
add
lw
js
push 1
beq label22
lfp
push 2
lfp
add
lw
push 1
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
b label23
label22:
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
push 1
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
lhp
sw
lhp
push 1
add
shp
label23:
b label19
label18:
push -1
label19:
srv
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

function9:
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
push 2
lfp
lw
add
lw
push 1
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

function10:
cfp
lra
lfp
push 1
lfp
add
lw
push -2
lfp
lw
add
lw
push 2
lfp
lw
add
lw
push 1
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

function11:
cfp
lra
push 1
lfp
add
lw
push -1
beq label26
push 0
b label27
label26:
push 1
label27:
push 1
beq label24
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
b label25
label24:
push 0
label25:
lfp
 push function9
lfp
 push function10
push 1
lfp
add
lw
push -1
beq label30
push 0
b label31
label30:
push 1
label31:
push 1
beq label28
lfp
push -2
lfp
add
lw
lfp
push 2
lfp
add
lw
push 1
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
push 1
lfp
add
lw
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
push label0
lhp
sw
lhp
push 1
add
shp
push label1
lhp
sw
lhp
push 1
add
shp
lfp
push 2
lfp
add
lw
push 1
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
push 1
lfp
add
lw
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
b label29
label28:
push -1
label29:
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

function12:
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
bleq label34
push 0
b label35
label34:
push 1
label35:
push 1
beq label32
push 1 
b label33
label32:
push 0 
label33:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function13:
cfp
lra
lfp
 push function12
lfp
push -2
lfp
add
lw
push -3
lfp
add
lw
push 1
lfp
add
lw
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

function14:
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
bleq label38
push 0
b label39
label38:
push 1
label39:
push 1
beq label36
push 1 
b label37
label36:
push 0 
label37:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function15:
cfp
lra
lfp
 push function14
lfp
push -2
lfp
add
lw
push -3
lfp
add
lw
push 1
lfp
add
lw
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
