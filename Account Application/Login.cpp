// Login.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "Login.h"
#include "MenuAll.h"
#include "Register.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CLogin dialog


CLogin::CLogin(CWnd* pParent /*=NULL*/)
	: CDialog(CLogin::IDD, pParent)
{
	//{{AFX_DATA_INIT(CLogin)
	m_strLogPassword = _T("");
	m_strLogName = _T("");
	//}}AFX_DATA_INIT
}


void CLogin::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CLogin)
	DDX_Text(pDX, IDC_EDIT2, m_strLogPassword);
	DDX_Text(pDX, IDC_EDIT1, m_strLogName);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CLogin, CDialog)
	//{{AFX_MSG_MAP(CLogin)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CLogin message handlers

void CLogin::OnButton1() 
{
	// ��¼
	UpdateData(true);       //���½���
	CDaoRecordset  DbSet(&TVXQ);    //�������ݿ�
	CString Filepath="TVXQ_Data.mdb";  //�����ݿ�start
	CString Sname,Spsw;
	_variant_t varname,varpsw;
	TVXQ.Open(Filepath);
	DbSet.Open(AFX_DAO_USE_DEFAULT_TYPE,"SELECT * FROM DataTable",0); //�����ݿ�end

	varname=DbSet.GetFieldValue("Name");   //��������
  	varpsw=DbSet.GetFieldValue("Psw");
    Sname=(LPCSTR)_bstr_t(varname);    //����ת����string

	int tvxq=0;


	while (!DbSet.IsEOF())
	{
		varname=DbSet.GetFieldValue("Name");   //��������
  	    varpsw=DbSet.GetFieldValue("Psw");
	    Sname=(LPCSTR)_bstr_t(varname);    //����ת����string
     	Spsw=(LPCSTR)_bstr_t(varpsw);
		if(m_strLogName.IsEmpty()||m_strLogPassword.IsEmpty())
		{
			MessageBox("��Ϣ����Ϊ��","������ʾ");
			return;
		}

		if(Sname.Compare(m_strLogName)==0&&Spsw.Compare(m_strLogPassword)==0)
		{
			IDName=Sname;
			m_strLogPassword="";
			m_strLogName="";
			UpdateData(false);
			DbSet.Close();    //�ر����ݿ�
			TVXQ.Close();
			CMenuAll dlg;
			if (dlg.DoModal()==IDOK)
			{
				dlg.DoModal();
			}
			tvxq=1;
			return;

		}
		else
		{
			DbSet.MoveNext();
		}
	}

	
	if (tvxq==0)
	{
		MessageBox("�˺Ż�����������������룡","�ɻ��󶹡�����");
		DbSet.Close();    //�ر����ݿ�
		TVXQ.Close();
		m_strLogPassword="";
		m_strLogName="";
		UpdateData(false);

	}
	
}

void CLogin::OnButton2() 
{
	// TODO: Add your control notification handler code here
	MessageBox("����ϵQQ��313751158");
}

BOOL CLogin::PreTranslateMessage(MSG* pMsg) 
{
	// TODO: Add your specialized code here and/or call the base class
	if (hAccTable)
	{
		if (::TranslateAccelerator(m_hWnd,hAccTable,pMsg))
		{
			return(true);
		}
	}
	return CDialog::PreTranslateMessage(pMsg);
}

BOOL CLogin::OnInitDialog() 
{
	CDialog::OnInitDialog();
	hAccTable=LoadAccelerators(AfxGetInstanceHandle(),MAKEINTRESOURCE(IDR_ACCELERATOR1));
	
	// TODO: Add extra initialization here


	
	return TRUE;  // return TRUE unless you set the focus to a control
	              // EXCEPTION: OCX Property Pages should return FALSE
}
