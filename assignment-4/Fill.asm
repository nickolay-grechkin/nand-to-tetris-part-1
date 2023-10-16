// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.
@SCREEN
D=A
@addr // 16384
M=D

@8191 // @8191 
D=A
@n
M=D

@i
M=0

(LISTENER)
    @i
    M=0
    @SCREEN
    D=A
    @addr // 16384
    M=D
    @KBD
    D=M
    @FILL_DARK
    D;JNE
    @FILL_LIGHT
    D;JEQ
    // @LISTENER
    // 0;JMP

(FILL_DARK)
    @i
    D=M // 0, 1, 2, 3 ...
    @n
    D=D-M // 3 - 4 = -1
    @LISTENER
    D;JGT

    @addr
    A=M // A = 16384
    M=-1 // M = RAM[16384] = -1

    @i
    M=M+1 
    @addr // 16384
    M=M+1 // M = 16384 + 32 = 16416
    @FILL_DARK
    0;JMP

(FILL_LIGHT)
    @i
    D=M // 0, 1, 2, 3 ...
    @n
    D=D-M // 3 - 4 = -1
    @LISTENER
    D;JGT

    @addr
    A=M // A = 16384
    M=0 // M = RAM[16384] = -1

    @i
    M=M+1  // D = 32
    @addr // 16384
    M=M+1 // M = 16384 + 32 = 16416
    @FILL_LIGHT
    0;JMP

(END)
    @END
    0;JMP

// @R0
// D=M
// @n
// M=D

// @SCREEN
// D=A
// @addr
// M=D

// @i
// M=0

// (FILL_DARK)
//     @i
//     D=M
//     @n
//     D=D-M
//     @LISTENER
//     D;JGT

//     @addr
//     A=M
//     M=-1

//     @i
//     M=M+1
//     @addr
//     M=D+1
//     @FILL_DARK
//     0;JMP

// (FILL_DARK)
//     @i
//     D=M
//     @n
//     D=D-M
//     @LISTENER
//     D;JGT

//     @addr
//     A=M
//     M=-1

//     @i
//     M=M+1
//     @32
//     D=A
//     @addr
//     M=D+M
//     @FILL_DARK
//     0;JMP

// (FILL_LIGHT)
//     @i
//     D=M
//     @n
//     D=D-M
//     @LISTENER
//     D;JGT

//     @addr
//     A=M
//     M=0

//     @i
//     M=M+1
//     @32
//     D=A
//     @addr
//     M=D+M
//     @FILL_LIGHT
//     0;JMP