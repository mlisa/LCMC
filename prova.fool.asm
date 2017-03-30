push 0

lfp
push g0
lfp
push k1
lfp
push f2
push 5
lfp
push t5
lfp
push a6
lfp
push -2
lfp
add
lw
push -3
lfp
add
lw
push -11
lfp
add
lw
push -12
lfp
add
lw
js
print
halt

g0:
cfp
lra
push 4
lfp
add
lw
push 3
lfp
add
lw
lfp
push 4
push 2
lfp
add
lw
push 1
lfp
add
lw
js
lfp
push 6
push -2
lfp
add
lw
push -3
lfp
add
lw
js
sub
srv
pop
pop
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

k1:
cfp
lra
push 1
lfp
add
lw
push 2
mult
srv
sra
pop
pop
sfp
lrv
lra
js

z3:
cfp
lra
push 1
lfp
add
lw
push 2
add
srv
sra
pop
pop
sfp
lrv
lra
js

h4:
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
push -3
lfp
lw
add
lw
js
push 5
mult
srv
sra
pop
pop
sfp
lrv
lra
js

f2:
cfp
lra
lfp
push z3
lfp
push h4
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
push 1
add
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

t5:
cfp
lra
push -8
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

a6:
cfp
lra
lfp
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
push 2
lfp
add
lw
push 1
lfp
add
lw
js
srv
sra
pop
pop
pop
sfp
lrv
lra
js
