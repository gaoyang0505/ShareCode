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
	// 登录
	UpdateData(true);       //更新界面
	CDaoRecordset  DbSet(&TVXQ);    //调用数据库
	CString Filepath="TVXQ_Data.mdb";  //打开数据库start
	CString Sname,Spsw;
	_variant_t varname,varpsw;
	TVXQ.Open(Filepath);
	DbSet.Open(AFX_DAO_USE_DEFAULT_TYPE,"SELECT * FROM DataTable",0); //打开数据库end

	varname=DbSet.GetFieldValue("Name");   //读入数据
  	varpsw=DbSet.GetFieldValue("Psw");
    Sname=(LPCSTR)_bstr_t(varname);    //类型转换至string

	int tvxq=0;


	while (!DbSet.IsEOF())
	{
		varname=DbSet.GetFieldValue("Name");   //读入数据
  	    varpsw=DbSet.GetFieldValue("Psw");
	    Sname=(LPCSTR)_bstr_t(varname);    //类型转换至string
     	Spsw=(LPCSTR)_bstr_t(varpsw);
		if(m_strLogName.IsEmpty()||m_strLogPassword.IsEmpty())
		{
			MessageBox("信息不能为空","温情提示");
			return;
		}

		if(Sname.Compare(m_strLogName)==0&&Spsw.Compare(m_strLogPassword)==0)
		{
			IDName=Sname;
			m_strLogPassword="";
			m_strLogName="";
			UpdateData(false);
			DbSet.Close();    //关闭数据库
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
		MessageBox("账号或密码错误，请重新输入！","采花大豆·记账");
		DbSet.Close();    //关闭数据库
		TVXQ.Close();
		m_strLogPassword="";
		m_strLogName="";
		UpdateData(false);

	}
	
}

void CLogin::OnButton2() 
{
	// TODO: Add your control notification handler code here
	MessageBox("请联系QQ：313751158");
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
