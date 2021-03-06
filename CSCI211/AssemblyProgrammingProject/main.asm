;Assembly Programming
;Leo Vergnetti

section	.text
	global _start       ;must be declared for using gcc
_start:                     ;tell linker entry point
    ;output 'hello what is your name?' 
	mov	edx, len    ;message length
	mov	ecx, msg    ;message to write
	mov	ebx, 1	    ;file descriptor (stdout)
	mov	eax, 4	    ;system call number (sys_write)
	int	0x80        ;call kernel
	
	;read input and store to name var
	mov edx, 16     ;length var
	mov ecx, name   ;variable to hold name
	mov ebx, 1      ;file descriptor (stdin)
	mov eax, 3      ;system call number (sys_read)
	int 0x80        ; call kernel
	
	;output 'hello'
	mov edx, leno   ;length of msgo
	mov ecx, msgo   ;msgo to output
	mov ebx, 1      ;file descriptor (stdout)
	mov eax, 4      ;system call number (sys_write)
	int 80h       ;call kernel
	
	;output name 
	mov edx, 16     ;length of name
	mov ecx, name   ;name variable
	mov ebx, 1      ;file descriptor (stdin)
	mov eax, 4      ;system call number (sys_write)
	int 0x80        ;call kernel
	
	mov	eax, 1	    ;system call number (sys_exit)
	int	0x80        ;call kernel

;constants
section	.data

msg	db	'Hello, what is your name?',0xa	;string with line break     
len	equ	$ - msg			;length of string

msgo db 'Hello '        ; string for responding to name
leno equ $ - msgo       ; length of string

;vars
section .bss
name resd 16;           ; variable for 16 doublebytes