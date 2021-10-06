import java.security.PublicKey;

//Q2. Your name & ID: Hung Tsz Him 18064518d
//Protein DNA begins with a start condon "ATG"
//Protein DNA ends with a stop condon "TGA"
//The length of Protein DNA is divisible by 3

public class DnaSequence {

    /* Add your source code here. Do not modify any source code given. You are  required to implement the method isProteinDNA. Alternatively, you can add two more methods here for the method isProteinDNA to use. */
    
    
        public static void main(String[] args) {
            String s1dna = "ATGCGATACTGA";
            String s2dna = "ATGCGATTACGTGA";
            String s3dna = "ATTAATATGTACTGA";
    
            DnaSequence sample1 = new DnaSequence();
            System.out.print(sample1.isProteinDNA(s1dna) + " ");
            DnaSequence sample2 = new DnaSequence();
            System.out.print(sample2.isProteinDNA(s2dna) + " ");
            DnaSequence sample3 = new DnaSequence();
            System.out.print(sample3.isProteinDNA(s3dna));


        }
    
        public String isProteinDNA(String input)
        {
            int correct = 1;

            if(input.length()%3 != 0) 
                correct = 0;
            if(input.charAt(0) != 'A'|| input.charAt(1) != 'T'||input.charAt(2) != 'G')
                correct = 0;
            if(input.charAt(input.length()-3) != 'T'|| input.charAt(input.length()-2) != 'G'||input.charAt(input.length()-1) != 'A')
                correct = 0;

            if (correct == 1)
            {
                return "true ";
            }
            else return "false ";
        }
    
    }