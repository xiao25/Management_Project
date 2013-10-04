/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/8/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
var itemsPerPage = 3;
var store = Ext.define('HT.store.Grade', {

    extend: 'Ext.data.Store',

    model: 'HT.model.Grade',
    pageSize: itemsPerPage,
    autoLoad: false,
    listeners: {

        'beforeload': (function () {

            var values =0;
            //Ext.apply(Ext.getStore("Grade").proxy.extraParams, {'id': 0});
            if(Ext.getCmp('Grade_inq')!=undefined){
            values = Ext.encode(Ext.getCmp('Grade_inq').getValues());
            }


            Ext.apply(
                Ext.getStore("Grade").proxy.extraParams,
                {'id': values
                });
        })

    },

    proxy: {
        type: 'ajax',
        api: {
            read: 'Grade/view.action',
            create: 'Grade/create.action',
            update: 'Grade/update.action',
            destroy: 'Grade/delete.action'
        },


        reader: {
            type: 'json',
            idProperty: 'id',
            root: 'data',
            success: 'success',
            totalProperty: 'total'


        },


        //The. new DataWriter component
        writer: {
            encode: true,
            writeAllFields: true,
            type: 'json',
            root: 'data'
        }

    }



});

