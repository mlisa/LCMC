push 0
lfp
 push function0
lfp
 push function1
lfp
 push function4
push 5
lfp
 push function7
lfp
 push function10
lfp
push -3
lfp
add
lw
lfp
push -7
lfp
add
lw
push -8
lfp
add
lw
js
print
halt

function0:
cfp
lra
push 1
lfp
add
lw
lfp
push 4
lfp
push 1
lfp
add
lw
push 0
lfp
add
lw
js
lfp
push 6
lfp
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

function1:
cfp
lra
push 1
lfp
add
lw
push 1
lfp
add
lw
push 2
mult
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

function2:
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

function3:
cfp
lra
lfp
push 1
lfp
add
lw
lfp
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

function4:
cfp
lra
lfp
 push function2
lfp
 push function3
lfp
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

function5:
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

function6:
cfp
lra
lfp
push 1
lfp
add
lw
lfp
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

function7:
cfp
lra
lfp
 push function5
lfp
 push function6
push -5
lfp
lw
add
lw
srv
pop
pop
pop
pop
sra
pop
sfp
lrv
lra
js

function8:
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

function9:
cfp
lra
lfp
push 1
lfp
add
lw
lfp
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

function10:
cfp
lra
lfp
 push function8
lfp
 push function9
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
lfp
push 1
lfp
add
lw
push 0
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
pop
sfp
lrv
lra
js
