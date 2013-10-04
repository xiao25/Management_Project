/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/6/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('HT.model.Courses',
    {
        //��Ҫ���˼̳�
        extend: 'Ext.data.Model',

        fields: [
            {name: 'id', mapping: 'id', type: 'string'},
            {name: 'kcm', mapping: 'kcm', type: 'string'},
            {name: 'ach', mapping: 'ach', type: 'int'},

            {name: 'remarks', mapping: 'remarks', type: 'string'}
        ]
    }
)