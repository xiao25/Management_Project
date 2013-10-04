var itemsPerPage = 3;
var store = Ext.define('HT.store.Students', {

    extend: 'Ext.data.Store',
    storeId: 'Student',
    model: 'HT.model.Students',
    pageSize: itemsPerPage,
    autoLoad: false,


    listeners: {

        'beforeload': (function () {

            values = Ext.getCmp('Inqumethod').getValues();
//            kcm = "{\"stuname\":" + Ext.encode(values.stuname) + "}";
//            kch = "{\"classnum\":" + Ext.encode(values.classnum) + "}";
            Ext.apply(
                Ext.getStore("Students").proxy.extraParams,
                {'data': Ext.encode(values)
                });
        })

    },
    proxy: {
        type: 'ajax',
        api: {
            read: 'student/view.action',
            create: 'student/create.action',
            update: 'student/update.action',
            destroy: 'student/delete.action'
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
