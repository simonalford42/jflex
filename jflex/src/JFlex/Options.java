/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * JFlex 1.4                                                               *
 * Copyright (C) 1998-2003  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * This program is free software; you can redistribute it and/or modify    *
 * it under the terms of the GNU General Public License. See the file      *
 * COPYRIGHT for more information.                                         *
 *                                                                         *
 * This program is distributed in the hope that it will be useful,         *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of          *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the           *
 * GNU General Public License for more details.                            *
 *                                                                         *
 * You should have received a copy of the GNU General Public License along *
 * with this program; if not, write to the Free Software Foundation, Inc., *
 * 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA                 *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package JFlex;

import java.io.File;

/**
 * Global JFlex options.
 * 
 * @author Gerwin Klein
 * @version JFlex 1.4, $Revision$, $Date$
 */
public class Options {
	
	/** code generation method: maximum packing */
	final public static int PACK   = 0;
	/** code generation method: traditional */
	final public static int TABLE  = 1;
	/** code generation method: switch statement */
	final public static int SWITCH = 2;


	/** output directory */
	private static File directory;

  /** don't run minimization algorithm if this is true */
  public static boolean no_minimize; 

  /** don't write backup files if this is true */
  public static boolean no_backup; 

  /** default code generation method */
  public static int gen_method;

	static { setDefaults();	}


  /**
   * @return the output directory
   */
  public static File getDir() {    
    return directory;
  }

  /**
   * Set output directory
   * 
   * @param dirName the name of the directory to write output files to
   */
  public static void setDir(String dirName) {
  	setDir(new File(dirName)); 
  }
  

	/**
	 * Set output directory
	 * 
	 * @param d  the directory to write output files to
	 */
  public static void setDir(File d) {
    if ( d.isFile() ) {
      Out.error("Error: \""+d+"\" is not a directory.");
      throw new GeneratorException();
    }
    
    if ( !d.isDirectory() && !d.mkdirs() ) {
      Out.error("Error: couldn't create directory \""+d+"\"");
      throw new GeneratorException();
    }
  
    directory = d;
  }

  /**
   * Sets all options back to default values. 
   */
  public static void setDefaults() {
  	directory = null;
		no_minimize = false;
		no_backup = false;
		gen_method = Options.PACK;    
  }   
}
