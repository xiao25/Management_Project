/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/13/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
var itemsPerPage = 3;
var store = Ext.define('HT.store.InquCur', {

    extend: 'Ext.data.Store',

    fields: [
        {name: 'stuid', type: 'int'},
        {name: 'stuname', type: 'string'},
        {name: 'classnum', type: 'string'},
        {name: 'grade', type: 'int'},
        {name: 'rank', tyep: 'int'}
    ],
    pageSize: itemsPerPage,
    autoLoad: false,
    sortOnLoad: true,
    sorters: {
        property: 'grade',
        direction: 'DESC'
    },


    listeners: {

        'beforeload': (function () {
            values = Ext.ComponentQuery.query('NewGriCur')[0].down('trigger').getValue();
            temp = Ext.encode(values.split(','));
            Ext.apply(Ext.getStore("InquCur").proxy.extraParams, { 'kcm': temp});
        })

    },
    proxy: {
        url: "/Grade/viewsbycur.action",
        type: 'ajax',
        reader: {
            type: 'json',

            root: 'data',
            success: 'success',
            totalProperty: 'total'


        }


    }





});
