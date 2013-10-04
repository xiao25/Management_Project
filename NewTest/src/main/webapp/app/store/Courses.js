/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/6/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
var itemsPerPage = 3;
var store = Ext.define('HT.store.Courses', {

    extend: 'Ext.data.Store',

    model: 'HT.model.Courses',
    pageSize: itemsPerPage,
    autoLoad: false,


    listeners: {

        'beforeload': (function () {
            values = Ext.getCmp('Cour_inq').getValues();
            kcm = "{\"kcm\":" + Ext.encode(values.kcm) + "}";
            kch = "{\"kch\":" + Ext.encode(values.classnum) + "}";
            Ext.apply(Ext.getStore("Courses").proxy.extraParams, {'Kch': kch, 'Kcm': kcm});
        })

    },
    proxy: {
        type: 'ajax',
        api: {
            read: 'Course/view.action',
            create: 'Course/create.action',
            update: 'Course/update.action',
            destroy: 'Course/delete.action'
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

