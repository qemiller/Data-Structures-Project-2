/**
 * 
 * @author Quinton Miller
 * @author Josh Rehm
 * @version 3/19/2019
 * 
 *          This program takes a list of commands from an input file and will
 *          input the data into a tree.
 *          These commands will be one of four commands, insert, remove, search,
 *          and print. The data in this tree
 *          is a DNA sequence of A, C, G, and T characters. The commands will be
 *          followed by a single string of
 *          those characters on the same line as the command.
 *          The print function does not take in a sequence, but
 *          will print the tree based on the type given to it. The command,
 *          "print", will output the tree as a
 *          straight dump. If the command was "print lengths", the program will
 *          print out the sequences along with the lengths
 *          of them. The final type is "print stats" which will print the
 *          sequence as well as the percentage of A's, C's, T's, and G's in the
 *          sequence.
 *          The flag to the commands is in the search commands. the syntax for
 *          search is "search 'sequence'". If the sequence has a $ charecter at
 *          the end of it,
 *          the program will look for an exact map of the sequence inputed. If
 *          the sequence has no $ character at the end, the program
 *          will look for all the sequences with 'sequence' as a prefix.
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class DNAtree {
    /**
     * 
     * @param args
     *            arguments from the function call
     * 
     *            runs the DNA tree program with the file from args.
     */
    public static void main(String[] args) {
        String fileName = args[0];
        Parse dnaParse = new Parse();
        dnaParse.parseFile(fileName);
    }
}
