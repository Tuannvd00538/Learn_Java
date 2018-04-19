/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Ngo Van Tuan
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
    String tableName();
}
