/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/8/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('HT.model.Grade',
    {
        //��Ҫ���˼̳�
        extend: 'Ext.data.Model',

        fields: [
            {name: 'id', mapping: 'id', type: 'int'},
            {name: 'curid', mapping: 'curid', type: 'string'},
            {name: 'stuid', mapping: 'student.stunum', type: 'string'},
            {name: 'ach', mapping: 'ach', type: 'int'} ,
            {name: 'kcm', mapping: 'course.kcm', type: 'string'} ,
            {name: 'stuname', mapping: 'student.stuname', type: 'string'}



        ]
    }
)