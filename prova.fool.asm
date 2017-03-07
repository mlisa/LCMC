push 0

lfp
 push function0
lfp
 push function1
push 3
push 3
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 2
print
b label1
label0:
lfp
push -2
lfp
add
lw
push -3
lfp
add
lw
push 5
push 3
push -4
lfp
add
lw
push -5
lfp
add
lw
js
print
label1:
halt

function0:
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
sub
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
lfp
push 2
lfp
add
lw
push 1
lfp
add
lw
push 4
lfp
add
lw
push 3
lfp
add
lw
js
push 2
lfp
add
lw
add
srv
sra
pop
pop
pop
pop
pop
sfp
lrv
lra
js
